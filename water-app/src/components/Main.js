import {Component} from "react";
import Header from "./Header";
import DateInput from "./DateInput";
import Overall from "./Overall";
import QuantityInput from "./QuantityInput";
import SubmitButton from "./SubmitButton";
import axios from "axios";

export default class Main extends Component {
    constructor(props) {
        super(props);

        this.state = {
            consumptionDate: '2022-01-01',
            overallQuantity: 0,
            quantity: 250,
            lastUpdate: ''
        };

        this.handleDateChange = this.handleDateChange.bind(this);
        this.handleQuantityChange = this.handleQuantityChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.updateState = this.updateState.bind(this);
    }

    componentDidMount() {
        this.getDataFromServer();
    }

    handleDateChange(newDate) {
        this.setState({
            consumptionDate: newDate
        });
        this.getDataFromServer(newDate);
    }

    handleQuantityChange(newQuantity) {
        this.setState({
            quantity: newQuantity
        });
    }

    handleSubmit() {
        const data = this.state;
        this.postDataToServer(data);
    }

    getDataFromServer(curDate) {
        const dateValue = curDate ?  curDate : '';
        axios.get('api/v1/water',
            {
                params: {
                    date: dateValue
                }
            })
            .then(response => {
                this.updateState(response.data);
            })
            .catch(error => {
                alert(error);
            });
    }

    postDataToServer(data) {
        axios.post('api/v1/water', data)
            .then(() => {
                this.getDataFromServer(data.consumptionDate);
            })
            .catch(error => {
                alert(error);
            });
    }

    updateState(responseData) {
        this.setState({
            consumptionDate: responseData.consumptionDate,
            overallQuantity: responseData.overallQuantity,
            quantity: responseData.quantity,
            lastUpdate: responseData.lastUpdate
        });
    }

    render() {
        const currentDate = this.state.consumptionDate;
        const overallQuantity = this.state.overallQuantity;
        const quantity = this.state.quantity;
        const lastUpdate = this.state.lastUpdate;

        return (
            <div>
                <Header/>
                <DateInput consumptionDate={currentDate} onDateChange={this.handleDateChange}/>
                <Overall overallQuantity={overallQuantity} lastUpdate={lastUpdate}/>
                <QuantityInput quantity={quantity} onQuantityChange={this.handleQuantityChange}/>
                <SubmitButton onSubmit={this.handleSubmit}/>
            </div>
        );
    }
}
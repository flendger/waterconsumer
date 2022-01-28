import {Component} from "react";
import Header from "./Header";
import DateInput from "./DateInput";
import Overall from "./Overall";
import QuantityInput from "./QuantityInput";
import SubmitButton from "./SubmitButton";

export default class Main extends Component {
    constructor(props) {
        super(props);

        this.state = {
            currentDate: '2022-01-28',
            overallQuantity: 1500,
            quantity: 250
        };

        this.handleDateChange = this.handleDateChange.bind(this);
        this.handleQuantityChange = this.handleQuantityChange.bind(this);
    }

    handleDateChange(newDate) {
        this.setState({
            currentDate: newDate
        });
    }

    handleQuantityChange(newQuantity) {
        this.setState({
            quantity: newQuantity
        });
    }

    render() {
        const currentDate = this.state.currentDate;
        const overallQuantity = this.state.overallQuantity;
        const quantity = this.state.quantity;

        return (
            <div>
                <Header/>
                <DateInput consumptionDate={currentDate} onDateChange={this.handleDateChange}/>
                <Overall overallQuantity={overallQuantity}/>
                <QuantityInput quantity={quantity} onQuantityChange={this.handleQuantityChange}/>
                <SubmitButton/>
            </div>
        );
    }
}
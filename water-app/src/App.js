import './App.css';
import {Component} from "react";
import Header from "./components/Header";
import DateInput from "./components/DateInput";
import Overall from "./components/Overall";
import QuantityInput from "./components/QuantityInput";
import SubmitButton from "./components/SubmitButton";


class Main extends Component {
    render() {
        return (
            <div>
                <Header/>
                <DateInput consumptionDate={new Date()}/>
                <Overall overallQuantity="ov example"/>
                <QuantityInput quantity={250}/>
                <SubmitButton/>
            </div>
        );
    }
}

function App() {
    return (
        <Main/>
    );
}

export default App;

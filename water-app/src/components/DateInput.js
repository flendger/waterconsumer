import {Component} from "react";

export default class DateInput extends Component {

    constructor(props, context) {
        super(props, context);

        this.handleDateChange = this.handleDateChange.bind(this);
    }

    handleDateChange(e) {
        const dateValue = e.target.value;

        this.props.onDateChange(dateValue);
    }

    render() {
        const dateValue = this.props.consumptionDate;

        return (
            <div className="mb-3 row">
                <div className="col-4">
                    <label htmlFor="consumptionDate" className="col-form-label">Date</label>
                </div>
                <div className="col">
                    <input type="date" value={dateValue} onChange={this.handleDateChange} className="form-control"
                           id="consumptionDate"/>
                </div>
            </div>
        );
    }
}

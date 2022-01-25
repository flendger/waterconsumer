import {Component} from "react";

export default class DateInput extends Component {
    render() {
        const date = this.props.consumptionDate.toISOString().substring(0, 10);
        return (
            <div className="mb-3 row">
                <div className="col-4">
                    <label htmlFor="consumptionDate" className="col-form-label">Date</label>
                </div>
                <div className="col">
                    <input type="date" defaultValue={date} className="form-control" id="consumptionDate"/>
                </div>
            </div>
        );
    }
}

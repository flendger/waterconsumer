import {Component} from "react";

class Overall extends Component {
    render() {
        return (
            <div className="mb-3 row">
                <div className="col-4">
                    <label htmlFor="staticConsumption" className="col-form-label">Overall (ml)</label>
                </div>
                <div className="col">
                    <input type="text" readOnly className="form-control-plaintext" id="staticConsumption" value={this.props.overallQuantity}/>
                </div>
            </div>
        );
    }
}

export default Overall;
import {Component} from "react";

class Overall extends Component {

    formatOverall(props) {
        function addLastUpdateValue(lastUpdate) {
            return lastUpdate ? '   upd: ' + lastUpdate.substring(0, 8) : '';
        }

        const overallQuantity = props.overallQuantity;
        const lastUpdate = props.lastUpdate;

        return overallQuantity + addLastUpdateValue(lastUpdate);
    }

    render() {
        const overallValue = this.formatOverall(this.props);

        return (
            <div className="mb-3 row">
                <div className="col-4">
                    <label htmlFor="staticConsumption" className="col-form-label">Overall (ml)</label>
                </div>
                <div className="col">
                    <input type="text" readOnly className="form-control-plaintext" id="staticConsumption" value={overallValue}/>
                </div>
            </div>
        );
    }
}

export default Overall;
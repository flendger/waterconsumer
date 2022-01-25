import React, {Component} from 'react';

class QuantityInput extends Component {
    render() {
        return (
            <div className="mb-3 row">
                <div className="col-4">
                    <label htmlFor="quantity" className="col-form-label">Quantity (ml)</label>
                </div>
                <div className="col">
                    <input type="number" defaultValue={this.props.quantity} className="form-control" id="quantity"/>
                </div>
            </div>
        );
    }
}

export default QuantityInput;
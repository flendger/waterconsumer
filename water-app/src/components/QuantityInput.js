import React, {Component} from 'react';

class QuantityInput extends Component {

    constructor(props, context) {
        super(props, context);

        this.onQuantityChange = this.onQuantityChange.bind(this);
    }

    onQuantityChange(e) {
        let value = e.target.value;

        this.props.onQuantityChange(value);
    }

    render() {
        return (
            <div className="mb-3 row">
                <div className="col-4">
                    <label htmlFor="quantity" className="col-form-label">Quantity (ml)</label>
                </div>
                <div className="col">
                    <input type="number" defaultValue={this.props.quantity} onChange={this.onQuantityChange} className="form-control" id="quantity"/>
                </div>
            </div>
        );
    }
}

export default QuantityInput;
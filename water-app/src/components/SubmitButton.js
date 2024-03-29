import React, {Component} from 'react';

class SubmitButton extends Component {
    render() {
        return (
            <div className="row mx-3 my-3 mt-3">
                <button type="button" className="btn btn-primary" onClick={this.props.onSubmit}>Confirm</button>
            </div>
        );
    }
}

export default SubmitButton;
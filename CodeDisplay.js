import React from 'react';
import './CodeDisplay.css'; // CSS 파일 임포트

const CodeDisplay = ({ code, onConfirm }) => {
  return (
    <div className="modal">
      <div className="modal-content">
        <h2>카카오 Auth Code</h2>
        <p>{code}</p>
      </div>
    </div>
  );
};

export default CodeDisplay;
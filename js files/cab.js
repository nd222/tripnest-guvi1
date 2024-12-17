// Set the trip type and toggle visibility of return date/time fields
function setTripType(type) {
    const oneWayActive = type === 'oneway';
    const roundTripActive = type === 'roundtrip';

    document.getElementById('return-date-group').style.display = roundTripActive ? 'block' : 'none';
    document.getElementById('return-time-group').style.display = roundTripActive ? 'block' : 'none';

    // Update active tab styling
    document.querySelectorAll('.trip-type button').forEach(button => {
        button.classList.remove('active');
    });
    document.querySelector(`button[onclick="setTripType('${type}')"]`).classList.add('active');
}

// Search Cab - for demo purposes, just alerts the selected details
function searchCab() {
    const pickup = document.getElementById('pickup').value;
    const drop = document.getElementById('drop').value;
    const date = document.getElementById('date').value;
    const time = document.getElementById('time').value;
    const carType = document.getElementById('car').value;

    if (!pickup || !drop || !date || !time) {
        alert('Please fill all required fields.');
        return;
    }

    alert(`Searching cab from ${pickup} to ${drop} on ${date} at ${time} in a ${carType}.`);
}

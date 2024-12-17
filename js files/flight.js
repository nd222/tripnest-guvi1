function selectTripType(type) {
    const returnDateGroup = document.getElementById('return-date-group');
    if (type === 'round-trip') {
        returnDateGroup.style.display = 'block';
    } else {
        returnDateGroup.style.display = 'none';
    }

    document.querySelectorAll('.tab-button').forEach(button => {
        button.classList.remove('active');
    });
    document.querySelector(`.tab-button[onclick="selectTripType('${type}')"]`).classList.add('active');
}

document.getElementById('flightForm').addEventListener('submit', function(e) {
    e.preventDefault();
    alert("Searching for flights...");
});

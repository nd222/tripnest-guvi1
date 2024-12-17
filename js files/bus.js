function searchBus() {
    const from = document.getElementById('from').value;
    const to = document.getElementById('to').value;
    const date = document.getElementById('date').value;
    const passengers = document.getElementById('passengers').value;

    if (!from || !to || !date) {
        alert('Please fill all required fields.');
        return;
    }

    alert(`Searching buses from ${from} to ${to} on ${date} for ${passengers} passengers.`);
}

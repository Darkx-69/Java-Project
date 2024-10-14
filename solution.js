// solution.js

// JavaScript to play/pause video on hover
const videoElement = document.querySelector('.video');

videoElement.addEventListener('mouseover', function() {
    videoElement.play();
});

videoElement.addEventListener('mouseout', function() {
    videoElement.pause();
});

// Google Charts logic for annual electricity production
google.charts.load("current", { packages: ['corechart'] });
google.charts.setOnLoadCallback(drawElectricityChart);

function drawElectricityChart() {
    var data = google.visualization.arrayToDataTable([
        ['Year', 'Solar Electricity (MWh)', 'Thermal Electricity (MWh)'],
        ['2019',  500, 1000],
        ['2020',  800, 900],
        ['2021',  1200, 800],
        ['2022',  1500, 600],
        ['2023',  2000, 500],
        ['2024',  2500, 400], // Latest year data
    ]);

    var options = {
        title: 'Annual Electricity Production Comparison',
        width: '100%',
        height: 500,
        bars: 'horizontal', // Required for Material Bar Charts.
        legend: { position: 'top' },
        animation: {
            duration: 1000,
            easing: 'out',
            startup: true
        },
        hAxis: {
            title: 'Electricity Production (MWh)',
        },
        vAxis: {
            title: 'Year',
        }
    };

    var chart = new google.visualization.BarChart(document.getElementById('electricity_chart'));
    chart.draw(data, options);
}

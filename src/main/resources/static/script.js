document.addEventListener('DOMContentLoaded', () => {
    // Get references to all game screens
    const gameScreens = document.querySelectorAll('.game-screen');
    const mainMenuScreen = document.getElementById('main-menu');
    const challengesScreen = document.getElementById('challenges-screen'); // UPDATED: Renamed from gameModesScreen and ID changed in HTML
    const normalLeaderboardScreen = document.getElementById('normal-leaderboard-screen');
    const settingsScreen = document.getElementById('settings-screen');

    // Get references to main menu buttons
    const playButton = document.getElementById('play-button');
    const highscoresButton = document.getElementById('highscores-button');
    const settingsButton = document.getElementById('settings-button');

    // Get reference to the settings back button
    const settingsBackButton = document.getElementById('settings-back-button');

    // Get reference to the leaderboard back button
    const leaderboardBackButton = document.getElementById('leaderboard-back-button');

    // NEW: Get reference to the challenges screen back button
    const challengesBackButton = document.getElementById('challenges-back-button');

    // Function to show a specific screen and hide others
    function showScreen(screenToShow) {
        gameScreens.forEach(screen => {
            screen.classList.remove('active'); // Hide all screens by removing active class
        });
        screenToShow.classList.add('active'); // Show the desired screen by adding active class
    }

    // Event Listeners for Main Menu Buttons
    playButton.addEventListener('click', () => {
        showScreen(challengesScreen); // UPDATED: Now transitions to the challenges screen
        console.log('Play button clicked, showing Challenges screen.');
    });

    highscoresButton.addEventListener('click', () => {
        showScreen(normalLeaderboardScreen); // Shows the Normal Leaderboard screen
        console.log('Highscores button clicked, showing Normal Leaderboard screen.');
    });

    settingsButton.addEventListener('click', () => {
        showScreen(settingsScreen); // This now correctly shows the settings screen
        console.log('Settings button clicked, showing Settings screen.');
    });

    // Event Listener for Settings Back Button
    settingsBackButton.addEventListener('click', () => {
        showScreen(mainMenuScreen);
        console.log('Back button clicked from Settings, showing Main Menu.');
    });

    // Event Listener for Leaderboard Back Button
    leaderboardBackButton.addEventListener('click', () => {
        showScreen(mainMenuScreen);
        console.log('Back button clicked from Leaderboard, showing Main Menu.');
    });

    // NEW: Event Listener for Challenges Screen Back Button
    challengesBackButton.addEventListener('click', () => {
        showScreen(mainMenuScreen);
        console.log('Back button clicked from Challenges, showing Main Menu.');
    });

    // Initialize: Show the main menu when the page loads
    showScreen(mainMenuScreen);
});
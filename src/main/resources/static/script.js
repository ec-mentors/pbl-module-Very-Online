document.addEventListener('DOMContentLoaded', () => {
    // Get references to all game screens
    const gameScreens = document.querySelectorAll('.game-screen');
    const mainMenuScreen = document.getElementById('main-menu');
    const challengesScreen = document.getElementById('challenges-screen');
    const leaderboardSelectionScreen = document.getElementById('leaderboard-selection-screen'); // NEW
    const normalLeaderboardScreen = document.getElementById('normal-leaderboard-screen');
    const speedLeaderboardScreen = document.getElementById('speed-leaderboard-screen'); // NEW
    const settingsScreen = document.getElementById('settings-screen');

    // Get references to main menu buttons
    const playButton = document.getElementById('play-button');
    const highscoresButton = document.getElementById('highscores-button');
    const settingsButton = document.getElementById('settings-button');

    // Get reference to the settings back button
    const settingsBackButton = document.getElementById('settings-back-button');

    // Get reference to the leaderboard selection screen back button // NEW
    const leaderboardSelectBackButton = document.getElementById('leaderboard-select-back-button');

    // Get references to the specific leaderboard screens' back buttons // UPDATED IDs
    const normalLeaderboardBackButton = document.getElementById('normal-leaderboard-back-button');
    const speedLeaderboardBackButton = document.getElementById('speed-leaderboard-back-button'); // NEW

    // NEW: Get references to the leaderboard selection buttons
    const normalLeaderboardSelectButton = document.getElementById('normal-leaderboard-select-button');
    const speedLeaderboardSelectButton = document.getElementById('speed-leaderboard-select-button');

    // Get reference to the challenges screen back button
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
        showScreen(challengesScreen);
        console.log('Play button clicked, showing Challenges screen.');
    });

    highscoresButton.addEventListener('click', () => {
        showScreen(leaderboardSelectionScreen); // UPDATED: Now shows the leaderboard selection screen
        console.log('Highscores button clicked, showing Leaderboard Selection screen.');
    });

    settingsButton.addEventListener('click', () => {
        showScreen(settingsScreen);
        console.log('Settings button clicked, showing Settings screen.');
    });

    // Event Listener for Settings Back Button
    settingsBackButton.addEventListener('click', () => {
        showScreen(mainMenuScreen);
        console.log('Back button clicked from Settings, showing Main Menu.');
    });

    // NEW Event Listeners for Leaderboard Selection Screen Buttons
    normalLeaderboardSelectButton.addEventListener('click', () => {
        showScreen(normalLeaderboardScreen); // Shows Normal Leaderboard
        console.log('Normal Leaderboard button clicked, showing Normal Leaderboard.');
    });

    speedLeaderboardSelectButton.addEventListener('click', () => {
        showScreen(speedLeaderboardScreen); // Shows Speed Leaderboard
        console.log('Speed Leaderboard button clicked, showing Speed Leaderboard.');
    });

    leaderboardSelectBackButton.addEventListener('click', () => {
        showScreen(mainMenuScreen); // Back to Main Menu
        console.log('Back button clicked from Leaderboard Selection, showing Main Menu.');
    });

    // UPDATED Event Listeners for Specific Leaderboard Back Buttons
    normalLeaderboardBackButton.addEventListener('click', () => {
        showScreen(leaderboardSelectionScreen); // Back to Leaderboard Selection
        console.log('Back button clicked from Normal Leaderboard, showing Leaderboard Selection.');
    });

    speedLeaderboardBackButton.addEventListener('click', () => {
        showScreen(leaderboardSelectionScreen); // Back to Leaderboard Selection
        console.log('Back button clicked from Speed Leaderboard, showing Leaderboard Selection.');
    });

    // Event Listener for Challenges Screen Back Button
    challengesBackButton.addEventListener('click', () => {
        showScreen(mainMenuScreen);
        console.log('Back button clicked from Challenges, showing Main Menu.');
    });

    // Initialize: Show the main menu when the page loads
    showScreen(mainMenuScreen);
});
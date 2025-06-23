document.addEventListener('DOMContentLoaded', () => {
    // Get references to all game screens
    const gameScreens = document.querySelectorAll('.game-screen');
    const mainMenuScreen = document.getElementById('main-menu');
    const gameModesScreen = document.getElementById('game-modes-screen');
    const normalLeaderboardScreen = document.getElementById('normal-leaderboard-screen');
    const settingsScreen = document.getElementById('settings-screen');

    // Get references to main menu buttons
    const playButton = document.getElementById('play-button');
    const highscoresButton = document.getElementById('highscores-button');
    const settingsButton = document.getElementById('settings-button');

    // Get reference to the settings back button
    const settingsBackButton = document.getElementById('settings-back-button');

    // Get reference to the leaderboard back button
    const leaderboardBackButton = document.getElementById('leaderboard-back-button'); // New

    // Function to show a specific screen and hide others
    function showScreen(screenToShow) {
        gameScreens.forEach(screen => {
            screen.classList.remove('active'); // Hide all screens by removing active class
        });
        screenToShow.classList.add('active'); // Show the desired screen by adding active class
    }

    // Event Listeners for Main Menu Buttons
    playButton.addEventListener('click', () => {
        showScreen(gameModesScreen); // Will transition to the game modes screen
        console.log('Play button clicked, showing Game Modes screen.');
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

    // Event Listener for Leaderboard Back Button (new, since we added leaderboards)
    leaderboardBackButton.addEventListener('click', () => {
        showScreen(mainMenuScreen);
        console.log('Back button clicked from Leaderboard, showing Main Menu.');
    });

    // Initialize: Show the main menu when the page loads
    showScreen(mainMenuScreen);
});
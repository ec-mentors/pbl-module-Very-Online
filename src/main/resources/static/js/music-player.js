document.addEventListener('DOMContentLoaded', () => {

    const audio = document.getElementById('background-music');
    if (!audio) return;

    const MUSIC_STATE_KEY = 'musicState'; // 'playing' or 'stopped'
    const MUSIC_TIME_KEY = 'musicTime';

    const musicToggleButton = document.getElementById('music-toggle-button');

    if (musicToggleButton) {
        const updateButtonVisuals = () => {
            if (sessionStorage.getItem(MUSIC_STATE_KEY) === 'playing') {
                musicToggleButton.textContent = '🎵';
                musicToggleButton.classList.remove('muted');
            } else {
                musicToggleButton.textContent = '🔇';
                musicToggleButton.classList.add('muted');
            }
        };

        updateButtonVisuals();

        musicToggleButton.addEventListener('click', () => {
            const currentState = sessionStorage.getItem(MUSIC_STATE_KEY);
            if (currentState === 'playing') {
                sessionStorage.setItem(MUSIC_STATE_KEY, 'stopped');
                audio.pause();
            } else {
                sessionStorage.setItem(MUSIC_STATE_KEY, 'playing');
                playMusic();
            }
            updateButtonVisuals();
        });
    }

    const playMusic = () => {
        const savedTime = sessionStorage.getItem(MUSIC_TIME_KEY);
        if (savedTime) {
            audio.currentTime = parseFloat(savedTime);
        }
        audio.play().catch(e => console.error("Error playing audio:", e));
    };

    window.addEventListener('beforeunload', () => {
        if (sessionStorage.getItem(MUSIC_STATE_KEY) === 'playing') {
            sessionStorage.setItem(MUSIC_TIME_KEY, audio.currentTime);
        }
    });

    if (sessionStorage.getItem(MUSIC_STATE_KEY) === 'playing') {
        playMusic();
    }
});
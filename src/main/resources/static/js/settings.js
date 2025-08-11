document.addEventListener('DOMContentLoaded', () => {
    const volumeSlider = document.getElementById('volume-slider');
    const volumeValueDisplay = document.getElementById('volume-value');
    const audio = document.getElementById('background-music');

    if (!volumeSlider || !audio) return;

    const VOLUME_KEY = 'musicVolume';

    // 1. Load saved volume from localStorage when the page loads
    const savedVolume = localStorage.getItem(VOLUME_KEY);
    if (savedVolume !== null) {
        volumeSlider.value = savedVolume;
        volumeValueDisplay.textContent = savedVolume;
        audio.volume = savedVolume / 100;
    }

    // 2. Add an event listener to the slider
    volumeSlider.addEventListener('input', () => {
        const newVolume = volumeSlider.value;

        // Update the audio volume in real-time
        audio.volume = newVolume / 100;

        // Update the displayed number
        volumeValueDisplay.textContent = newVolume;

        // 3. Save the new volume setting to localStorage
        localStorage.setItem(VOLUME_KEY, newVolume);
    });
});
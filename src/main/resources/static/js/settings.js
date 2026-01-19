document.addEventListener('DOMContentLoaded', () => {
    const volumeSlider = document.getElementById('volume-slider');
    const volumeValueDisplay = document.getElementById('volume-value');
    const audio = document.getElementById('background-music');

    if (!volumeSlider || !audio) return;

    const VOLUME_KEY = 'musicVolume';

    const savedVolume = localStorage.getItem(VOLUME_KEY);
    if (savedVolume !== null) {
        volumeSlider.value = savedVolume;
        volumeValueDisplay.textContent = savedVolume;
        audio.volume = savedVolume / 100;
    }

    volumeSlider.addEventListener('input', () => {
        const newVolume = volumeSlider.value;

        audio.volume = newVolume / 100;

        volumeValueDisplay.textContent = newVolume;

        localStorage.setItem(VOLUME_KEY, newVolume);
    });
});

document.addEventListener('DOMContentLoaded', () => {
    const questionBox = document.querySelector('.question-box');

    // Only run this code if we are on a page with a question box
    if (questionBox) {
        const questionText = questionBox.querySelector('h2');

        // Check if the content's full height is greater than the box's visible height
        const isOverflowing = questionText.scrollHeight > questionBox.clientHeight;

        if (isOverflowing) {
            // If it's overflowing, add our special class
            questionBox.classList.add('is-overflowing');
        }
    }
});
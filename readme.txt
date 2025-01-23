1. How to run?

    In project root directory run command:

        docker compose up

    In different console window run e.g.

        curl -X POST http://localhost:8080/api/shuffle \
             -H "Content-Type: application/json" \
            -d '{"numbersToShuffleCount": 5}'

    In first console window, logs will be visible.

2. What's next? We can discuss on technical better solutions for sorting algorithm.
    It would be worth a while to add:
        - swagger documentation to endpoint,
        - better exception handling and meaningful responses in case of issues.
 int[][] colors = { RED, GREEN, BLUE };
        int[] directions = {1, -1}; // 1 = forward, -1 = backward

        for (int i = 0; i < moves; i++) {
            int[] color = colors[i % colors.length];
            int tone = TONES[i % TONES.length];
            int direction = directions[i % directions.length];

            // Set lights
            bird.setBeak(color[0], color[1], color[2]);
            bird.setTail("all", color[0], color[1], color[2]);

            // Play sound
            bird.buzz(tone, 500);

            // Move
            if (direction == 1) {
                bird.setWheelVelocities(100, 100, 1000); // forward
            } else {
                bird.setWheelVelocities(-100, -100, 1000); // backward
            }

            bird.sleep(500); // pause between moves
        }

        // Finish dance
        bird.setBeak(0, 0, 0);
        bird.setTail("all", 0, 0, 0);
        bird.saySomething("Dance complete!");
        bird.quit();
    }
}
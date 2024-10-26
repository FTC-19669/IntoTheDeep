package com.example.meepmeep;

import com.acmerobotics.roadrunner.Pose2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MeepMeepVisualizer {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
            // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
            .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 13)
            .build();

        myBot.runAction(myBot.getDrive().actionBuilder(new Pose2d(39.5, -63.5, Math.toRadians(0)))
            .setTangent(Math.toRadians(170))
            .splineToSplineHeading(new Pose2d(-50,-63.5, Math.toRadians(0)), Math.toRadians(190))
            .waitSeconds(2)
            .setTangent(Math.toRadians(10))
            .splineToSplineHeading(new Pose2d(38, -35, Math.toRadians(45)), Math.toRadians(45))
            .waitSeconds(1)
            .setTangent(Math.toRadians(220))
            .splineToSplineHeading(new Pose2d(-50, -63.5, Math.toRadians(0)), Math.toRadians(190))
            .waitSeconds(2)
            .setTangent(Math.toRadians(10))
            .splineToSplineHeading(new Pose2d(48, -35, Math.toRadians(45)), Math.toRadians(45))
            .waitSeconds(1)
            .setTangent(Math.toRadians(210))
            .splineToSplineHeading(new Pose2d(-50, -63.5, Math.toRadians(0)), Math.toRadians(190))
            .waitSeconds(2)
            .setTangent(Math.toRadians(10))
            .splineToSplineHeading(new Pose2d(58, -35, Math.toRadians(45)), Math.toRadians(45))
            .waitSeconds(1)
            .setTangent(Math.toRadians(210))
            .splineToSplineHeading(new Pose2d(-50, -63.5, Math.toRadians(0)), Math.toRadians(190))
            .build());

            meepMeep.setBackground(MeepMeep.Background.FIELD_INTO_THE_DEEP_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
        }
    }

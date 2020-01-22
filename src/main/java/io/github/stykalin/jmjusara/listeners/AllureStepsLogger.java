package io.github.stykalin.jmjusara.listeners;

import io.qameta.allure.listener.StepLifecycleListener;
import io.qameta.allure.model.StepResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Logging test steps, register as service.
 *
 * @author Aleksandr Stykalin
 */
public class AllureStepsLogger implements StepLifecycleListener {
    private static final Logger LOGGER = LoggerFactory.getLogger("StepLogger");

    @Override
    public void afterStepStart(StepResult result) {
        LOGGER.info("START: {}", result.getName());
    }

    @Override
    public void beforeStepStop(StepResult result) {
        LOGGER.info("FINISHED: {}", result.getName());
    }
}


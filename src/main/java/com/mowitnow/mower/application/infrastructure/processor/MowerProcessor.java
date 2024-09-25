package com.mowitnow.mower.application.infrastructure.processor;

import com.mowitnow.mower.application.domain.model.Mower;
import com.mowitnow.mower.application.domain.services.MowerService;
import org.springframework.batch.item.ItemProcessor;

public class MowerProcessor implements ItemProcessor<Mower, Mower> {

  private final MowerService mowerService;

  public MowerProcessor(MowerService mowerService) {
    this.mowerService = mowerService;
  }

  @Override
  public Mower process(Mower mower) {
    return mowerService.applyCommands(mower, mower.instructions());
  }
}

package com.mowitnow.mower.application.infrastructure.writer;

import com.mowitnow.mower.application.domain.model.Mower;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;

public class MowerOutputWriter implements ItemWriter<Mower> {

  @Override
  public void write(Chunk<? extends Mower> chunk) {
    for (Mower mower : chunk) {
      System.out.println("Final Position: " + mower);
    }
  }
}

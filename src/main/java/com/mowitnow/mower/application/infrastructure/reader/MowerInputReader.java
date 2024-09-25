package com.mowitnow.mower.application.infrastructure.reader;

import com.mowitnow.mower.application.domain.model.Mower;
import com.mowitnow.mower.application.domain.model.Orientation;
import org.springframework.batch.item.ItemReader;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MowerInputReader implements ItemReader<Mower> {

  private final List<Mower> mowers;
  private int nextMowerIndex;

  public MowerInputReader(String filePath) {
    this.mowers = loadMowersFromFile(filePath);
    this.nextMowerIndex = 0;
  }

  private List<Mower> loadMowersFromFile(String filePath) {
    List<Mower> mowers = new ArrayList<>();
    try {
      ClassPathResource resource = new ClassPathResource(filePath);
      BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));

      reader.readLine();

      String line;
      while ((line = reader.readLine()) != null) {
        String[] position = line.split(" ");
        int x = Integer.parseInt(position[0]);
        int y = Integer.parseInt(position[1]);
        Orientation orientation = Orientation.valueOf(position[2]);
        String instructions = reader.readLine();
        mowers.add(new Mower(x, y, orientation, instructions));
      }
      reader.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return mowers;
  }

  @Override
  public Mower read() {
    if (nextMowerIndex < mowers.size()) {
      return mowers.get(nextMowerIndex++);
    }
    return null;
  }
}

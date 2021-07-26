/* 
 * Thomas Nunn
 * 
 * TCSS 305A - Spring 2012
 * Project Tetris
 */

package view;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;


/**
 * This enum class for creating sound effects was adapted from the code example at
 * http://www3.ntu.edu.sg/home/ehchua/programming/java/J8c_PlayingSound.html.
 * 
 * @author Unknown
 * @author Thomas Nunn
 * @version 5/24/2012
 */
public enum TETRISWAVES {

  /**
   * The sound effect when a Tetris Piece freezes.
   */
  FREEZE("/home/tmn7/WorkSpaces/IntelliJ/tetris2/src/main/java/view/pipebang.wav"),

  /**
   * The sound effect when the game is over.
   */
  GAME_OVER("/home/tmn7/WorkSpaces/IntelliJ/tetris2/src/main/java/view/aaaaagh.wav"),

  /**
   * Background music for game play.
   */
  BACKGROUND_MUSIC("/home/tmn7/WorkSpaces/IntelliJ/tetris2/src/main/java/view/TetrisMusic.wav"),

  /**
   * The sound effect when a Piece tries to rotate but cannot.
   */
  ROTATE_DENIED("/home/tmn7/WorkSpaces/IntelliJ/tetris2/src/main/java/view/beep2.wav"),

  /**
   * The sound effect a Piece makes when it rotates.
   */
  ROTATE_SOUND("/home/tmn7/WorkSpaces/IntelliJ/tetris2/src/main/java/view/button-46.wav");

  /**
   * Each sound effect has its own clip, loaded with its own sound file.
   */
  private Clip my_clip;
  

  /**
   * Constructs each element of the enum with its own sound file.
   * 
   * @param the_file_name The name of a sound file.
   */
  TETRISWAVES(final String the_file_name) {

    try {

      // File for the AudioInputStream
      final File sound_file = new File(the_file_name);

      // Set up an audio input stream piped from the sound file.
      final AudioInputStream audio_input_stream = AudioSystem.getAudioInputStream(sound_file);
      
      // Get a clip resource.
      my_clip = AudioSystem.getClip();
      
      // Open audio clip and load samples from the audio input stream.
      my_clip.open(audio_input_stream);

    } catch (final UnsupportedAudioFileException usf_e) {
      usf_e.printStackTrace();
    } catch (final IOException io_e) {
      io_e.printStackTrace();
    } catch (final LineUnavailableException lu_e) {
      lu_e.printStackTrace();
    }
  }

  /**
   * @return True if a TETRISWAVE is currently running.
   */
  public boolean isRunning() {
    return my_clip.isRunning();
  }

  /**
   * Resets a TetrisWave sound to the beginning of file.
   */
  public void reset() {
    my_clip.setFramePosition(0); // reset to the beginning.
  }

  /**
   * Plays a TETRISWAVE sound from its last position.
   */
  public void play() {
    my_clip.start();   
  }

  /**
   * Plays a TETRISWAVE sound in a continuous loop.
   */
  public void loop() {
    my_clip.loop(Clip.LOOP_CONTINUOUSLY);
  }

  /**
   * Stops a currently playing TETRISWAVE sound.
   */
  public void stop() {
    my_clip.stop();
  }

  /**
   * Pre-loads all the sound files.
   */
  public static void init() {
    values(); // calls the constructor for all the elements
  }
}
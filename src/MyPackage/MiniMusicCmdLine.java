package MyPackage;

import javax.sound.midi.*;


public class MiniMusicCmdLine {

    public void play(int instrument, int note) {

        try {
            Sequencer player = MidiSystem.getSequencer();
            player.open();

            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            MidiEvent event = null;

            ShortMessage a = new ShortMessage();
            a.setMessage(192, 1, instrument, 100);
            MidiEvent changeInstrument = new MidiEvent(a, 1);
            track.add(changeInstrument);

            ShortMessage b = new ShortMessage();
            b.setMessage(144, 1, note, 100);
            MidiEvent noteOn = new MidiEvent(b, 1);
            track.add(noteOn);

            ShortMessage c = new ShortMessage();
            c.setMessage(128, 1, note, 100);
            MidiEvent noteOff = new MidiEvent(c,16);
            track.add(noteOff);

            player.setSequence(seq);
            player.start();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }  // close play



    public static void main(String[] args) {
        MiniMusicCmdLine mini = new MiniMusicCmdLine();
        if (args.length < 2) {
            System.out.println("Don't forget the instrument and note args");
        } else {
            int instrument = Integer.parseInt(args[0]);
            int note = Integer.parseInt(args[1]);
            mini.play(instrument, note);
        }
    } // close main
} // close class
import javax.sound.midi.*;



public class MiniMiniMusicApp {

    public void play() {

        try {
            Sequencer player = MidiSystem.getSequencer();
            player.open();

            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            ShortMessage a = new ShortMessage();
            a.setMessage(192, 1, 102,0);
            MidiEvent changeInstrument = new MidiEvent(a, 1);
            track.add(changeInstrument);

            ShortMessage b = new ShortMessage();
            b.setMessage(144, 1, 44, 100);
            MidiEvent noteOn = new MidiEvent(b, 1);
            track.add(noteOn);

            ShortMessage c = new ShortMessage();
            c.setMessage(128, 1, 44, 100);
            MidiEvent noteOff = new MidiEvent(c,16);
            track.add(noteOff);

            player.setSequence(seq);
            player.start();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }  // close play



    public static void main(String[] args) {
        MiniMiniMusicApp mini = new MiniMiniMusicApp();
        mini.play();

    } // close main
} // close class

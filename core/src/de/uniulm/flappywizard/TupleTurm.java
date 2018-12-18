package de.uniulm.flappywizard;

import com.badlogic.gdx.graphics.Texture;
import org.w3c.dom.Text;

public class TupleTurm<X> {
    private final Texture Turm;
    private final Texture Dementor;

    private final float heightTurm;
    private final float heightDementor;

    private float PosX = 0;

    public TupleTurm(Texture Turm, Texture Dementor, float Abstand, float TurmHeightPoint) {
        this.Turm = Turm;
        this.Dementor = Dementor;

        this.heightTurm = TurmHeightPoint;
        this.heightDementor = heightTurm + Abstand;
    }

    public Texture getTurm() {
        return Turm;
    }

    public Texture getDementor() {
        return Dementor;
    }

    public float getHeightTurm() {
        return heightTurm;
    }

    public float getHeightDementor() {
        return heightDementor;
    }

    public float getPosX() {
        return PosX;
    }

    public void setPosX(float posX) {
        PosX = posX;
    }
}

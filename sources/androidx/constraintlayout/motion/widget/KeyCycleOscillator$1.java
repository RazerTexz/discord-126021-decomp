package androidx.constraintlayout.motion.widget;

import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public class KeyCycleOscillator$1 implements Comparator<KeyCycleOscillator$WavePoint> {
    public final /* synthetic */ KeyCycleOscillator this$0;

    public KeyCycleOscillator$1(KeyCycleOscillator keyCycleOscillator) {
        this.this$0 = keyCycleOscillator;
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(KeyCycleOscillator$WavePoint keyCycleOscillator$WavePoint, KeyCycleOscillator$WavePoint keyCycleOscillator$WavePoint2) {
        return compare2(keyCycleOscillator$WavePoint, keyCycleOscillator$WavePoint2);
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(KeyCycleOscillator$WavePoint keyCycleOscillator$WavePoint, KeyCycleOscillator$WavePoint keyCycleOscillator$WavePoint2) {
        return Integer.compare(keyCycleOscillator$WavePoint.mPosition, keyCycleOscillator$WavePoint2.mPosition);
    }
}

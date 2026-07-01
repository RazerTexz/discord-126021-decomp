package b.i.a.c;

import android.os.Bundle;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.c.Bundleable;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class o0 implements Bundleable.a {
    public static final /* synthetic */ o0 a = new o0();

    @Override // b.i.a.c.Bundleable.a
    public final Bundleable a(Bundle bundle) {
        Bundleable heartRating;
        int i = bundle.getInt(Integer.toString(0, 36), -1);
        if (i == 0) {
            AnimatableValueParser.j(bundle.getInt(HeartRating.a(0), -1) == 0);
            if (bundle.getBoolean(HeartRating.a(1), false)) {
                return new HeartRating(bundle.getBoolean(HeartRating.a(2), false));
            }
            heartRating = new HeartRating();
        } else if (i == 1) {
            AnimatableValueParser.j(bundle.getInt(Integer.toString(0, 36), -1) == 1);
            float f = bundle.getFloat(Integer.toString(1, 36), -1.0f);
            if (f != -1.0f) {
                return new PercentageRating(f);
            }
            heartRating = new PercentageRating();
        } else {
            if (i != 2) {
                if (i != 3) {
                    throw new IllegalArgumentException(outline.g(44, "Encountered unknown rating type: ", i));
                }
                AnimatableValueParser.j(bundle.getInt(ThumbRating.a(0), -1) == 3);
                return bundle.getBoolean(ThumbRating.a(1), false) ? new ThumbRating(bundle.getBoolean(ThumbRating.a(2), false)) : new ThumbRating();
            }
            AnimatableValueParser.j(bundle.getInt(StarRating.a(0), -1) == 2);
            int i2 = bundle.getInt(StarRating.a(1), 5);
            float f2 = bundle.getFloat(StarRating.a(2), -1.0f);
            if (f2 != -1.0f) {
                return new StarRating(i2, f2);
            }
            heartRating = new StarRating(i2);
        }
        return heartRating;
    }
}

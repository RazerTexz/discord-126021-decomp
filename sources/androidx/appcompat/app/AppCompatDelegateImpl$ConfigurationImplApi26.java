package androidx.appcompat.app;

import android.content.res.Configuration;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(26)
public class AppCompatDelegateImpl$ConfigurationImplApi26 {
    private AppCompatDelegateImpl$ConfigurationImplApi26() {
    }

    public static void generateConfigDelta_colorMode(@NonNull Configuration configuration, @NonNull Configuration configuration2, @NonNull Configuration configuration3) {
        int i = configuration.colorMode & 3;
        int i2 = configuration2.colorMode;
        if (i != (i2 & 3)) {
            configuration3.colorMode |= i2 & 3;
        }
        int i3 = configuration.colorMode & 12;
        int i4 = configuration2.colorMode;
        if (i3 != (i4 & 12)) {
            configuration3.colorMode |= i4 & 12;
        }
    }
}

package androidx.exifinterface.media;

import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;

/* JADX INFO: loaded from: classes.dex */
public class ExifInterface$Rational {
    public final long denominator;
    public final long numerator;

    public ExifInterface$Rational(double d) {
        this((long) (d * 10000.0d), 10000L);
    }

    public double calculate() {
        return this.numerator / this.denominator;
    }

    public String toString() {
        return this.numerator + AutocompleteViewModel.COMMAND_DISCOVER_TOKEN + this.denominator;
    }

    public ExifInterface$Rational(long j, long j2) {
        if (j2 == 0) {
            this.numerator = 0L;
            this.denominator = 1L;
        } else {
            this.numerator = j;
            this.denominator = j2;
        }
    }
}

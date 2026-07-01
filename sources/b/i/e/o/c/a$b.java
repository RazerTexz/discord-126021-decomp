package b.i.e.o.c;

import b.i.e.k;
import com.discord.widgets.chat.input.MentionUtilsKt;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;

/* JADX INFO: compiled from: Detector.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a$b {
    public final k a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f1851b;
    public final int c;

    public a$b(k kVar, k kVar2, int i, a$a a_a) {
        this.a = kVar;
        this.f1851b = kVar2;
        this.c = i;
    }

    public String toString() {
        return this.a + AutocompleteViewModel.COMMAND_DISCOVER_TOKEN + this.f1851b + MentionUtilsKt.SLASH_CHAR + this.c;
    }
}

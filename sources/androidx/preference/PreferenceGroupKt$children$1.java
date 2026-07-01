package androidx.preference;

import java.util.Iterator;
import kotlin.sequences.Sequence;

/* JADX INFO: compiled from: PreferenceGroup.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PreferenceGroupKt$children$1 implements Sequence<Preference> {
    public final /* synthetic */ PreferenceGroup $this_children;

    public PreferenceGroupKt$children$1(PreferenceGroup preferenceGroup) {
        this.$this_children = preferenceGroup;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<Preference> iterator() {
        return PreferenceGroupKt.iterator(this.$this_children);
    }
}

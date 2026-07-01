package androidx.preference;

import d0.z.d.g0.a;
import java.util.Iterator;

/* JADX INFO: compiled from: PreferenceGroup.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PreferenceGroupKt$iterator$1 implements Iterator<Preference>, a {
    public final /* synthetic */ PreferenceGroup $this_iterator;
    private int index;

    public PreferenceGroupKt$iterator$1(PreferenceGroup preferenceGroup) {
        this.$this_iterator = preferenceGroup;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.$this_iterator.getPreferenceCount();
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Preference next() {
        return next();
    }

    @Override // java.util.Iterator
    public void remove() {
        PreferenceGroup preferenceGroup = this.$this_iterator;
        int i = this.index - 1;
        this.index = i;
        preferenceGroup.removePreference(preferenceGroup.getPreference(i));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public Preference next() {
        PreferenceGroup preferenceGroup = this.$this_iterator;
        int i = this.index;
        this.index = i + 1;
        Preference preference = preferenceGroup.getPreference(i);
        if (preference != null) {
            return preference;
        }
        throw new IndexOutOfBoundsException();
    }
}

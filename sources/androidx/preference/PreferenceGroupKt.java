package androidx.preference;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;
import p507d0.p592z.p594d.p595g0.InterfaceC12228a;

/* JADX INFO: compiled from: PreferenceGroup.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PreferenceGroupKt {

    /* JADX INFO: renamed from: androidx.preference.PreferenceGroupKt$iterator$1 */
    /* JADX INFO: compiled from: PreferenceGroup.kt */
    public static final class C05231 implements Iterator<Preference>, InterfaceC12228a {
        public final /* synthetic */ PreferenceGroup $this_iterator;
        private int index;

        public C05231(PreferenceGroup preferenceGroup) {
            this.$this_iterator = preferenceGroup;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.$this_iterator.getPreferenceCount();
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

    public static final boolean contains(PreferenceGroup preferenceGroup, Preference preference) {
        C12238m.checkParameterIsNotNull(preferenceGroup, "$this$contains");
        C12238m.checkParameterIsNotNull(preference, "preference");
        int preferenceCount = preferenceGroup.getPreferenceCount();
        for (int i = 0; i < preferenceCount; i++) {
            if (C12238m.areEqual(preferenceGroup.getPreference(i), preference)) {
                return true;
            }
        }
        return false;
    }

    public static final void forEach(PreferenceGroup preferenceGroup, Function1<? super Preference, Unit> function1) {
        C12238m.checkParameterIsNotNull(preferenceGroup, "$this$forEach");
        C12238m.checkParameterIsNotNull(function1, "action");
        int preferenceCount = preferenceGroup.getPreferenceCount();
        for (int i = 0; i < preferenceCount; i++) {
            function1.invoke(get(preferenceGroup, i));
        }
    }

    public static final void forEachIndexed(PreferenceGroup preferenceGroup, Function2<? super Integer, ? super Preference, Unit> function2) {
        C12238m.checkParameterIsNotNull(preferenceGroup, "$this$forEachIndexed");
        C12238m.checkParameterIsNotNull(function2, "action");
        int preferenceCount = preferenceGroup.getPreferenceCount();
        for (int i = 0; i < preferenceCount; i++) {
            function2.invoke(Integer.valueOf(i), get(preferenceGroup, i));
        }
    }

    public static final <T extends Preference> T get(PreferenceGroup preferenceGroup, CharSequence charSequence) {
        C12238m.checkParameterIsNotNull(preferenceGroup, "$this$get");
        C12238m.checkParameterIsNotNull(charSequence, "key");
        return (T) preferenceGroup.findPreference(charSequence);
    }

    public static final Sequence<Preference> getChildren(final PreferenceGroup preferenceGroup) {
        C12238m.checkParameterIsNotNull(preferenceGroup, "$this$children");
        return new Sequence<Preference>() { // from class: androidx.preference.PreferenceGroupKt$children$1
            @Override // kotlin.sequences.Sequence
            public Iterator<Preference> iterator() {
                return PreferenceGroupKt.iterator(preferenceGroup);
            }
        };
    }

    public static final int getSize(PreferenceGroup preferenceGroup) {
        C12238m.checkParameterIsNotNull(preferenceGroup, "$this$size");
        return preferenceGroup.getPreferenceCount();
    }

    public static final boolean isEmpty(PreferenceGroup preferenceGroup) {
        C12238m.checkParameterIsNotNull(preferenceGroup, "$this$isEmpty");
        return preferenceGroup.getPreferenceCount() == 0;
    }

    public static final boolean isNotEmpty(PreferenceGroup preferenceGroup) {
        C12238m.checkParameterIsNotNull(preferenceGroup, "$this$isNotEmpty");
        return preferenceGroup.getPreferenceCount() != 0;
    }

    public static final Iterator<Preference> iterator(PreferenceGroup preferenceGroup) {
        C12238m.checkParameterIsNotNull(preferenceGroup, "$this$iterator");
        return new C05231(preferenceGroup);
    }

    public static final void minusAssign(PreferenceGroup preferenceGroup, Preference preference) {
        C12238m.checkParameterIsNotNull(preferenceGroup, "$this$minusAssign");
        C12238m.checkParameterIsNotNull(preference, "preference");
        preferenceGroup.removePreference(preference);
    }

    public static final void plusAssign(PreferenceGroup preferenceGroup, Preference preference) {
        C12238m.checkParameterIsNotNull(preferenceGroup, "$this$plusAssign");
        C12238m.checkParameterIsNotNull(preference, "preference");
        preferenceGroup.addPreference(preference);
    }

    public static final Preference get(PreferenceGroup preferenceGroup, int i) {
        C12238m.checkParameterIsNotNull(preferenceGroup, "$this$get");
        Preference preference = preferenceGroup.getPreference(i);
        if (preference != null) {
            return preference;
        }
        StringBuilder sbM834V = C1643a.m834V("Index: ", i, ", Size: ");
        sbM834V.append(preferenceGroup.getPreferenceCount());
        throw new IndexOutOfBoundsException(sbM834V.toString());
    }
}

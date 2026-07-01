package androidx.preference;

import androidx.exifinterface.media.ExifInterface;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import d0.z.d.g0.KMarkers;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;

/* JADX INFO: renamed from: androidx.preference.PreferenceGroupKt, reason: use source file name */
/* JADX INFO: compiled from: PreferenceGroup.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PreferenceGroup2 {

    /* JADX INFO: renamed from: androidx.preference.PreferenceGroupKt$iterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: PreferenceGroup.kt */
    public static final class AnonymousClass1 implements Iterator<Preference>, KMarkers {
        public final /* synthetic */ PreferenceGroup $this_iterator;
        private int index;

        public AnonymousClass1(PreferenceGroup preferenceGroup) {
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
        Intrinsics3.checkParameterIsNotNull(preferenceGroup, "$this$contains");
        Intrinsics3.checkParameterIsNotNull(preference, "preference");
        int preferenceCount = preferenceGroup.getPreferenceCount();
        for (int i = 0; i < preferenceCount; i++) {
            if (Intrinsics3.areEqual(preferenceGroup.getPreference(i), preference)) {
                return true;
            }
        }
        return false;
    }

    public static final void forEach(PreferenceGroup preferenceGroup, Function1<? super Preference, Unit> function1) {
        Intrinsics3.checkParameterIsNotNull(preferenceGroup, "$this$forEach");
        Intrinsics3.checkParameterIsNotNull(function1, "action");
        int preferenceCount = preferenceGroup.getPreferenceCount();
        for (int i = 0; i < preferenceCount; i++) {
            function1.invoke(get(preferenceGroup, i));
        }
    }

    public static final void forEachIndexed(PreferenceGroup preferenceGroup, Function2<? super Integer, ? super Preference, Unit> function2) {
        Intrinsics3.checkParameterIsNotNull(preferenceGroup, "$this$forEachIndexed");
        Intrinsics3.checkParameterIsNotNull(function2, "action");
        int preferenceCount = preferenceGroup.getPreferenceCount();
        for (int i = 0; i < preferenceCount; i++) {
            function2.invoke(Integer.valueOf(i), get(preferenceGroup, i));
        }
    }

    public static final <T extends Preference> T get(PreferenceGroup preferenceGroup, CharSequence charSequence) {
        Intrinsics3.checkParameterIsNotNull(preferenceGroup, "$this$get");
        Intrinsics3.checkParameterIsNotNull(charSequence, "key");
        return (T) preferenceGroup.findPreference(charSequence);
    }

    public static final Sequence<Preference> getChildren(final PreferenceGroup preferenceGroup) {
        Intrinsics3.checkParameterIsNotNull(preferenceGroup, "$this$children");
        return new Sequence<Preference>() { // from class: androidx.preference.PreferenceGroupKt$children$1
            @Override // kotlin.sequences.Sequence
            public Iterator<Preference> iterator() {
                return PreferenceGroup2.iterator(preferenceGroup);
            }
        };
    }

    public static final int getSize(PreferenceGroup preferenceGroup) {
        Intrinsics3.checkParameterIsNotNull(preferenceGroup, "$this$size");
        return preferenceGroup.getPreferenceCount();
    }

    public static final boolean isEmpty(PreferenceGroup preferenceGroup) {
        Intrinsics3.checkParameterIsNotNull(preferenceGroup, "$this$isEmpty");
        return preferenceGroup.getPreferenceCount() == 0;
    }

    public static final boolean isNotEmpty(PreferenceGroup preferenceGroup) {
        Intrinsics3.checkParameterIsNotNull(preferenceGroup, "$this$isNotEmpty");
        return preferenceGroup.getPreferenceCount() != 0;
    }

    public static final Iterator<Preference> iterator(PreferenceGroup preferenceGroup) {
        Intrinsics3.checkParameterIsNotNull(preferenceGroup, "$this$iterator");
        return new AnonymousClass1(preferenceGroup);
    }

    public static final void minusAssign(PreferenceGroup preferenceGroup, Preference preference) {
        Intrinsics3.checkParameterIsNotNull(preferenceGroup, "$this$minusAssign");
        Intrinsics3.checkParameterIsNotNull(preference, "preference");
        preferenceGroup.removePreference(preference);
    }

    public static final void plusAssign(PreferenceGroup preferenceGroup, Preference preference) {
        Intrinsics3.checkParameterIsNotNull(preferenceGroup, "$this$plusAssign");
        Intrinsics3.checkParameterIsNotNull(preference, "preference");
        preferenceGroup.addPreference(preference);
    }

    public static final Preference get(PreferenceGroup preferenceGroup, int i) {
        Intrinsics3.checkParameterIsNotNull(preferenceGroup, "$this$get");
        Preference preference = preferenceGroup.getPreference(i);
        if (preference != null) {
            return preference;
        }
        StringBuilder sbV = outline.V("Index: ", i, ", Size: ");
        sbV.append(preferenceGroup.getPreferenceCount());
        throw new IndexOutOfBoundsException(sbV.toString());
    }
}

package com.discord.models.commands;

import d0.z.d.Intrinsics3;
import java.util.Comparator;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ModelApplicationComparator.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelApplicationComparator {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: ModelApplicationComparator.kt */
    public static final class Companion implements Comparator<Application> {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // java.util.Comparator
        public int compare(Application a, Application b2) {
            Intrinsics3.checkNotNullParameter(a, "a");
            Intrinsics3.checkNotNullParameter(b2, "b");
            int i = (a.getBuiltIn() ? 1 : 0) - (b2.getBuiltIn() ? 1 : 0);
            return i != 0 ? i : a.getName().compareTo(b2.getName());
        }
    }
}

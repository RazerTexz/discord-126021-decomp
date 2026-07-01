package com.discord.widgets.servers.member_verification.form_fields;

import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;

/* JADX INFO: compiled from: MemberVerificationItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface MemberVerificationItem extends MGRecyclerDataPayload {
    public static final int APPROVE_TERMS = 2;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int HEADER = 0;
    public static final int MULTIPLE_CHOICE = 6;
    public static final int PARAGRAPH = 5;
    public static final int TERM = 3;
    public static final int TERMS_HEADER = 1;
    public static final int TEXT_INPUT = 4;

    /* JADX INFO: compiled from: MemberVerificationItem.kt */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int APPROVE_TERMS = 2;
        public static final int HEADER = 0;
        public static final int MULTIPLE_CHOICE = 6;
        public static final int PARAGRAPH = 5;
        public static final int TERM = 3;
        public static final int TERMS_HEADER = 1;
        public static final int TEXT_INPUT = 4;

        private Companion() {
        }
    }
}

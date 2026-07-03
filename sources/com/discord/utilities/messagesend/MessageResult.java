package com.discord.utilities.messagesend;

import com.discord.models.message.Message;
import com.discord.utilities.error.Error;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: MessageQueue.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class MessageResult {

    /* JADX INFO: compiled from: MessageQueue.kt */
    public static final class AutoModBlock extends MessageResult {
        private final Error error;
        private final Message message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AutoModBlock(Error error, Message message) {
            super(null);
            C12238m.checkNotNullParameter(error, "error");
            this.error = error;
            this.message = message;
        }

        public final Error getError() {
            return this.error;
        }

        public final Message getMessage() {
            return this.message;
        }
    }

    /* JADX INFO: compiled from: MessageQueue.kt */
    public static final class CaptchaRequired extends MessageResult {
        private final long channelId;
        private final Error error;
        private final String nonce;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CaptchaRequired(Error error, long j, String str) {
            super(null);
            C12238m.checkNotNullParameter(error, "error");
            this.error = error;
            this.channelId = j;
            this.nonce = str;
        }

        public final long getChannelId() {
            return this.channelId;
        }

        public final Error getError() {
            return this.error;
        }

        public final String getNonce() {
            return this.nonce;
        }
    }

    /* JADX INFO: compiled from: MessageQueue.kt */
    public static final class NetworkFailure extends MessageResult {
        public static final NetworkFailure INSTANCE = new NetworkFailure();

        private NetworkFailure() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: MessageQueue.kt */
    public static final class NoValidContent extends MessageResult {
        public static final NoValidContent INSTANCE = new NoValidContent();

        private NoValidContent() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: MessageQueue.kt */
    public static final class RateLimited extends MessageResult {
        private final long retryAfterMs;

        public RateLimited(long j) {
            super(null);
            this.retryAfterMs = j;
        }

        public final long getRetryAfterMs() {
            return this.retryAfterMs;
        }
    }

    /* JADX INFO: compiled from: MessageQueue.kt */
    public static final class Slowmode extends MessageResult {
        private final long cooldownMs;

        public Slowmode(long j) {
            super(null);
            this.cooldownMs = j;
        }

        public final long getCooldownMs() {
            return this.cooldownMs;
        }
    }

    /* JADX INFO: compiled from: MessageQueue.kt */
    public static final class Success extends MessageResult {
        private final com.discord.api.message.Message message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Success(com.discord.api.message.Message message) {
            super(null);
            C12238m.checkNotNullParameter(message, "message");
            this.message = message;
        }

        public final com.discord.api.message.Message getMessage() {
            return this.message;
        }
    }

    /* JADX INFO: compiled from: MessageQueue.kt */
    public static final class Timeout extends MessageResult {
        public static final Timeout INSTANCE = new Timeout();

        private Timeout() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: MessageQueue.kt */
    public static final class UnknownFailure extends MessageResult {
        private final Error error;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UnknownFailure(Error error) {
            super(null);
            C12238m.checkNotNullParameter(error, "error");
            this.error = error;
        }

        public final Error getError() {
            return this.error;
        }
    }

    /* JADX INFO: compiled from: MessageQueue.kt */
    public static final class UserCancelled extends MessageResult {
        public static final UserCancelled INSTANCE = new UserCancelled();

        private UserCancelled() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: MessageQueue.kt */
    public static final class ValidationError extends MessageResult {
        private final String message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ValidationError(String str) {
            super(null);
            C12238m.checkNotNullParameter(str, "message");
            this.message = str;
        }

        public final String getMessage() {
            return this.message;
        }
    }

    private MessageResult() {
    }

    public /* synthetic */ MessageResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

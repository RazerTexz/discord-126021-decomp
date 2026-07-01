package com.discord.widgets.chat.input.autocomplete;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.models.commands.ApplicationCommandOption;
import com.lytefast.flexinput.model.Attachment;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: com.discord.widgets.chat.input.autocomplete.Event, reason: use source file name */
/* JADX INFO: compiled from: AutocompleteViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AutocompleteViewModel5 {

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.autocomplete.Event$PickAttachment */
    /* JADX INFO: compiled from: AutocompleteViewModel.kt */
    public static final /* data */ class PickAttachment extends AutocompleteViewModel5 {
        private final ApplicationCommandOption commandOption;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PickAttachment(ApplicationCommandOption applicationCommandOption) {
            super(null);
            Intrinsics3.checkNotNullParameter(applicationCommandOption, "commandOption");
            this.commandOption = applicationCommandOption;
        }

        public static /* synthetic */ PickAttachment copy$default(PickAttachment pickAttachment, ApplicationCommandOption applicationCommandOption, int i, Object obj) {
            if ((i & 1) != 0) {
                applicationCommandOption = pickAttachment.commandOption;
            }
            return pickAttachment.copy(applicationCommandOption);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ApplicationCommandOption getCommandOption() {
            return this.commandOption;
        }

        public final PickAttachment copy(ApplicationCommandOption commandOption) {
            Intrinsics3.checkNotNullParameter(commandOption, "commandOption");
            return new PickAttachment(commandOption);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof PickAttachment) && Intrinsics3.areEqual(this.commandOption, ((PickAttachment) other).commandOption);
            }
            return true;
        }

        public final ApplicationCommandOption getCommandOption() {
            return this.commandOption;
        }

        public int hashCode() {
            ApplicationCommandOption applicationCommandOption = this.commandOption;
            if (applicationCommandOption != null) {
                return applicationCommandOption.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("PickAttachment(commandOption=");
            sbU.append(this.commandOption);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.autocomplete.Event$PreviewAttachment */
    /* JADX INFO: compiled from: AutocompleteViewModel.kt */
    public static final /* data */ class PreviewAttachment extends AutocompleteViewModel5 {
        private final Attachment<?> attachment;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PreviewAttachment(Attachment<?> attachment) {
            super(null);
            Intrinsics3.checkNotNullParameter(attachment, "attachment");
            this.attachment = attachment;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PreviewAttachment copy$default(PreviewAttachment previewAttachment, Attachment attachment, int i, Object obj) {
            if ((i & 1) != 0) {
                attachment = previewAttachment.attachment;
            }
            return previewAttachment.copy(attachment);
        }

        public final Attachment<?> component1() {
            return this.attachment;
        }

        public final PreviewAttachment copy(Attachment<?> attachment) {
            Intrinsics3.checkNotNullParameter(attachment, "attachment");
            return new PreviewAttachment(attachment);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof PreviewAttachment) && Intrinsics3.areEqual(this.attachment, ((PreviewAttachment) other).attachment);
            }
            return true;
        }

        public final Attachment<?> getAttachment() {
            return this.attachment;
        }

        public int hashCode() {
            Attachment<?> attachment = this.attachment;
            if (attachment != null) {
                return attachment.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("PreviewAttachment(attachment=");
            sbU.append(this.attachment);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.autocomplete.Event$RequestAutocompleteData */
    /* JADX INFO: compiled from: AutocompleteViewModel.kt */
    public static final /* data */ class RequestAutocompleteData extends AutocompleteViewModel5 {
        private final ApplicationCommandOption option;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RequestAutocompleteData(ApplicationCommandOption applicationCommandOption) {
            super(null);
            Intrinsics3.checkNotNullParameter(applicationCommandOption, "option");
            this.option = applicationCommandOption;
        }

        public static /* synthetic */ RequestAutocompleteData copy$default(RequestAutocompleteData requestAutocompleteData, ApplicationCommandOption applicationCommandOption, int i, Object obj) {
            if ((i & 1) != 0) {
                applicationCommandOption = requestAutocompleteData.option;
            }
            return requestAutocompleteData.copy(applicationCommandOption);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ApplicationCommandOption getOption() {
            return this.option;
        }

        public final RequestAutocompleteData copy(ApplicationCommandOption option) {
            Intrinsics3.checkNotNullParameter(option, "option");
            return new RequestAutocompleteData(option);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof RequestAutocompleteData) && Intrinsics3.areEqual(this.option, ((RequestAutocompleteData) other).option);
            }
            return true;
        }

        public final ApplicationCommandOption getOption() {
            return this.option;
        }

        public int hashCode() {
            ApplicationCommandOption applicationCommandOption = this.option;
            if (applicationCommandOption != null) {
                return applicationCommandOption.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("RequestAutocompleteData(option=");
            sbU.append(this.option);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.autocomplete.Event$ScrollAutocompletablesToApplication */
    /* JADX INFO: compiled from: AutocompleteViewModel.kt */
    public static final /* data */ class ScrollAutocompletablesToApplication extends AutocompleteViewModel5 {
        private final long applicationId;
        private final int targetPosition;

        public ScrollAutocompletablesToApplication(long j, int i) {
            super(null);
            this.applicationId = j;
            this.targetPosition = i;
        }

        public static /* synthetic */ ScrollAutocompletablesToApplication copy$default(ScrollAutocompletablesToApplication scrollAutocompletablesToApplication, long j, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                j = scrollAutocompletablesToApplication.applicationId;
            }
            if ((i2 & 2) != 0) {
                i = scrollAutocompletablesToApplication.targetPosition;
            }
            return scrollAutocompletablesToApplication.copy(j, i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getApplicationId() {
            return this.applicationId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getTargetPosition() {
            return this.targetPosition;
        }

        public final ScrollAutocompletablesToApplication copy(long applicationId, int targetPosition) {
            return new ScrollAutocompletablesToApplication(applicationId, targetPosition);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ScrollAutocompletablesToApplication)) {
                return false;
            }
            ScrollAutocompletablesToApplication scrollAutocompletablesToApplication = (ScrollAutocompletablesToApplication) other;
            return this.applicationId == scrollAutocompletablesToApplication.applicationId && this.targetPosition == scrollAutocompletablesToApplication.targetPosition;
        }

        public final long getApplicationId() {
            return this.applicationId;
        }

        public final int getTargetPosition() {
            return this.targetPosition;
        }

        public int hashCode() {
            return (b.a(this.applicationId) * 31) + this.targetPosition;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ScrollAutocompletablesToApplication(applicationId=");
            sbU.append(this.applicationId);
            sbU.append(", targetPosition=");
            return outline.B(sbU, this.targetPosition, ")");
        }
    }

    private AutocompleteViewModel5() {
    }

    public /* synthetic */ AutocompleteViewModel5(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

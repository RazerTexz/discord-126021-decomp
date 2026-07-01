package com.discord.stores;

import b.d.b.a.outline;
import com.discord.api.commands.ApplicationCommandAutocompleteChoice;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StoreApplicationCommands.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class CommandAutocompleteState {

    /* JADX INFO: compiled from: StoreApplicationCommands.kt */
    public static final /* data */ class Choices extends CommandAutocompleteState {
        private final List<ApplicationCommandAutocompleteChoice> choices;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Choices(List<ApplicationCommandAutocompleteChoice> list) {
            super(null);
            Intrinsics3.checkNotNullParameter(list, "choices");
            this.choices = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Choices copy$default(Choices choices, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = choices.choices;
            }
            return choices.copy(list);
        }

        public final List<ApplicationCommandAutocompleteChoice> component1() {
            return this.choices;
        }

        public final Choices copy(List<ApplicationCommandAutocompleteChoice> choices) {
            Intrinsics3.checkNotNullParameter(choices, "choices");
            return new Choices(choices);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof Choices) && Intrinsics3.areEqual(this.choices, ((Choices) other).choices);
            }
            return true;
        }

        public final List<ApplicationCommandAutocompleteChoice> getChoices() {
            return this.choices;
        }

        public int hashCode() {
            List<ApplicationCommandAutocompleteChoice> list = this.choices;
            if (list != null) {
                return list.hashCode();
            }
            return 0;
        }

        public String toString() {
            return outline.L(outline.U("Choices(choices="), this.choices, ")");
        }
    }

    /* JADX INFO: compiled from: StoreApplicationCommands.kt */
    public static final class Failed extends CommandAutocompleteState {
        public static final Failed INSTANCE = new Failed();

        private Failed() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: StoreApplicationCommands.kt */
    public static final class Loading extends CommandAutocompleteState {
        public static final Loading INSTANCE = new Loading();

        private Loading() {
            super(null);
        }
    }

    private CommandAutocompleteState() {
    }

    public /* synthetic */ CommandAutocompleteState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

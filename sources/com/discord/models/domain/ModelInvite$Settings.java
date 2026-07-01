package com.discord.models.domain;

import b.d.b.a.a;

/* JADX INFO: loaded from: classes.dex */
public class ModelInvite$Settings {
    public static final int NEVER = 0;
    public static final int ONE_DAY = 86400;
    public static final int ONE_HOUR = 3600;
    private final int maxAge;
    private final int maxUses;
    private final boolean temporary;
    public static final int SEVEN_DAYS = 604800;
    public static final int TWELVE_HOURS = 43200;
    public static final int SIX_HOURS = 21600;
    public static final int HALF_HOUR = 1800;
    public static final int[] EXPIRES_AFTER_ARRAY = {0, SEVEN_DAYS, 86400, TWELVE_HOURS, SIX_HOURS, 3600, HALF_HOUR};
    public static final int[] MAX_USES_ARRAY = {0, 1, 10, 100};

    public ModelInvite$Settings(int i, int i2, boolean z2) {
        this.maxAge = i;
        this.maxUses = i2;
        this.temporary = z2;
    }

    public boolean canEqual(Object obj) {
        return obj instanceof ModelInvite$Settings;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ModelInvite$Settings)) {
            return false;
        }
        ModelInvite$Settings modelInvite$Settings = (ModelInvite$Settings) obj;
        return modelInvite$Settings.canEqual(this) && getMaxAge() == modelInvite$Settings.getMaxAge() && getMaxUses() == modelInvite$Settings.getMaxUses() && isTemporary() == modelInvite$Settings.isTemporary();
    }

    public int getMaxAge() {
        return this.maxAge;
    }

    public int getMaxUses() {
        return this.maxUses;
    }

    public int hashCode() {
        return ((getMaxUses() + ((getMaxAge() + 59) * 59)) * 59) + (isTemporary() ? 79 : 97);
    }

    public boolean isTemporary() {
        return this.temporary;
    }

    public ModelInvite$Settings mergeMaxAge(int i) {
        return new ModelInvite$Settings(i, this.maxUses, this.temporary);
    }

    public ModelInvite$Settings mergeMaxUses(int i) {
        return new ModelInvite$Settings(this.maxAge, i, this.temporary);
    }

    public ModelInvite$Settings mergeTemporary(boolean z2) {
        return new ModelInvite$Settings(this.maxAge, this.maxUses, z2);
    }

    public String toString() {
        StringBuilder sbU = a.U("ModelInvite.Settings(maxAge=");
        sbU.append(getMaxAge());
        sbU.append(", maxUses=");
        sbU.append(getMaxUses());
        sbU.append(", temporary=");
        sbU.append(isTemporary());
        sbU.append(")");
        return sbU.toString();
    }

    public ModelInvite$Settings(int i) {
        this.maxAge = i;
        this.maxUses = 0;
        this.temporary = false;
    }
}

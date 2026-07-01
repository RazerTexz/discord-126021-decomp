package com.discord.api.science;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: Science.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class Science$Event$SchemaObject extends Science$Event {
    private final AnalyticsSchema schema;
    private final String type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Science$Event$SchemaObject(AnalyticsSchema analyticsSchema) {
        super(null);
        m.checkNotNullParameter(analyticsSchema, "schema");
        this.schema = analyticsSchema;
        this.type = analyticsSchema.getAnalyticsSchemaTypeName();
    }

    @Override // com.discord.api.science.Science$Event
    /* JADX INFO: renamed from: a, reason: from getter */
    public String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final AnalyticsSchema getSchema() {
        return this.schema;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof Science$Event$SchemaObject) && m.areEqual(this.schema, ((Science$Event$SchemaObject) other).schema);
        }
        return true;
    }

    public int hashCode() {
        AnalyticsSchema analyticsSchema = this.schema;
        if (analyticsSchema != null) {
            return analyticsSchema.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("SchemaObject(schema=");
        sbU.append(this.schema);
        sbU.append(")");
        return sbU.toString();
    }
}

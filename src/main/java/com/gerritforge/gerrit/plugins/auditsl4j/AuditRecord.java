// Copyright (C) 2025 GerritForge, Inc.
//
// Licensed under the BSL 1.1 (the "License");
// you may not use this file except in compliance with the License.
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.gerritforge.gerrit.plugins.auditsl4j;

import com.google.gerrit.server.AuditEvent;

public class AuditRecord {
  public final String type;
  public final AuditEvent event;

  public AuditRecord(AuditEvent event) {
    super();

    String eventClass = event.getClass().getName();
    this.type = eventClass.substring(eventClass.lastIndexOf('.') + 1);
    this.event = event;
  }

  public AuditRecord(AuditEvent event, TransformableAuditLogType type) {
    super();

    this.type = type.name();
    this.event = event;
  }
}

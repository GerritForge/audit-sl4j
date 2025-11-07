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
import com.google.gerrit.server.audit.AuditListener;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class LoggerAudit implements AuditListener {
  private final AuditWriter auditWriter;
  private final AuditFormatRenderer auditRenderer;

  public static final String AUDIT_LOGGER_NAME = LoggerAudit.class.getName();

  @Inject
  public LoggerAudit(AuditWriter auditWriter, AuditFormatRenderer auditRenderer) {
    this.auditWriter = auditWriter;
    this.auditRenderer = auditRenderer;

    auditRenderer.headers().ifPresent(auditWriter::write);
  }

  @Override
  public void onAuditableAction(AuditEvent auditEvent) {
    String auditString = getAuditString(auditEvent);
    auditWriter.write(auditString);
  }

  public String getAuditString(AuditEvent auditEvent) {
    return auditRenderer.render(auditEvent);
  }

  public String getAuditString(AuditEvent auditEvent, TransformableAuditLogType type) {
    return auditRenderer.render(auditEvent, type);
  }
}

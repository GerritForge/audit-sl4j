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

import com.google.gerrit.server.CurrentUser;
import com.google.gerrit.server.account.GroupMembership;
import java.util.Optional;

public class AuditUser extends CurrentUser {
  String username;

  @Override
  public GroupMembership getEffectiveGroups() {
    return null;
  }

  @Override
  public Optional<String> getUserName() {
    return Optional.of(username);
  }

  public void setUserName(String username) {
    this.username = username;
  }

  @Override
  public Object getCacheKey() {
    return getAccountId();
  }
}

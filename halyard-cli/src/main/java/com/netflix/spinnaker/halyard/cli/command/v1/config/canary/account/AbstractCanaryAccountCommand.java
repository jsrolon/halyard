/*
 * Copyright 2018 Google, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License")
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.netflix.spinnaker.halyard.cli.command.v1.config.canary.account;

import com.beust.jcommander.Parameters;

@Parameters(separators = "=")
public abstract class AbstractCanaryAccountCommand extends AbstractHasCanaryAccountCommand {

  @Override
  public String getCommandName() {
    return "account";
  }

  @Override
  public String getShortDescription() {
    return "Manage and view Spinnaker configuration for the " + getServiceIntegration() + " service integration's canary accounts.";
  }

  @Override
  public String getLongDescription() {
    return getShortDescription();
  }

  protected AbstractCanaryAccountCommand() {
    registerSubcommand(new GetCanaryAccountCommand(getServiceIntegration()));
    registerSubcommand(new DeleteCanaryAccountCommand(getServiceIntegration()));
    registerSubcommand(new ListCanaryAccountsCommand(getServiceIntegration()));
  }

  @Override
  protected void executeThis() {
    showHelp();
  }
}
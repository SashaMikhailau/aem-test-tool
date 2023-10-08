# aem-test-tool

![Build](https://github.com/SashaMikhailau/aem-test-tool/workflows/Build/badge.svg)
[![Version](https://img.shields.io/jetbrains/plugin/v/PLUGIN_ID.svg)](https://plugins.jetbrains.com/plugin/PLUGIN_ID)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/PLUGIN_ID.svg)](https://plugins.jetbrains.com/plugin/PLUGIN_ID)

<!-- Plugin description -->
The AEM Data Wizard plugin for IntelliJ IDEA is a tool designed to simplify and enhance the development workflow for Adobe Experience Manager (AEM) projects. AEM developers often work with JSON and XML files containing technical AEM data, such as metadata and properties like `jcr:created`, `cq:lastModified`, and more. This plugin streamlines the process of removing these technical properties from your JSON and XML files, making it easier to work with clean, focused data.

**Key Features:**

1. **Effortless Data Cleaning:** With just a click of a button or a keyboard shortcut, AEM developers can effortlessly remove technical AEM properties from JSON and XML files, ensuring cleaner, more readable data.

2. **Customizable Configuration:** The plugin comes pre-configured with a default list of technical properties to remove, including `jcr:uuid`, `cq:lastModified*`, `jcr:lastModified*`, `jcr:created*`, `jcr:isCheckedOut`, `cq:lastReplicat*`, `dam:extracted`, `dam:assetState`, `dc:modified`, and `*_x0040_*`. However, developers have the flexibility to customize this list in the plugin settings to match their specific project requirements.

3. **Seamless Integration:** AEM Data Wizard integrates seamlessly with IntelliJ IDEA, making it a natural part of your development environment. It simplifies the process of cleaning AEM data, allowing you to focus on writing and maintaining code.

**Use Case:**
Imagine you're working on an AEM project, and you have JSON or XML files with extensive technical AEM properties that clutter your data. Instead of manually removing these properties, you can use the AEM Data Wizard plugin. Navigate to any JSON or XML file, and you'll find the **AEM: Clear JSON/XML** button in context menu. Click it, and the plugin will instantly remove the technical AEM properties, leaving you with clean, concise data to work with.
<!-- Plugin description end -->

## Installation

- Using IDE built-in plugin system:
  
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>Marketplace</kbd> > <kbd>Search for "aem-test-tool"</kbd> >
  <kbd>Install Plugin</kbd>
  
- Manually:

  Download the [latest release](https://github.com/SashaMikhailau/aem-test-tool/releases/latest) and install it manually using
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>


---
Plugin based on the [IntelliJ Platform Plugin Template][template].

[template]: https://github.com/JetBrains/intellij-platform-plugin-template
[docs:plugin-description]: https://plugins.jetbrains.com/docs/intellij/plugin-user-experience.html#plugin-description-and-presentation
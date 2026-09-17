# 🧠 AI Document Intelligence & Summarization System

A production-ready **Spring Boot + LangChain4j** application that uses **Large Language Models (LLMs)** to summarize documents, answer questions, and extract structured information from unstructured text — **100% free and offline** using Ollama.

![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3.5-green)
![LangChain4j](https://img.shields.io/badge/LangChain4j-0.35.0-orange)
![License](https://img.shields.io/badge/License-MIT-yellow)

---

## ✨ Features

- 📄 **Multi-format ingestion** — PDF, DOCX, TXT via Apache Tika
- 🧠 **LLM-powered summarization** with structured prompt engineering
- ❓ **Context-aware Q&A** over any document
- 🔍 **Structured key-information extraction** (JSON output)
- ✅ **Input validation** with custom error messages
- 🛡️ **Global exception handling** with clean JSON responses
- 🌐 **RESTful API** with 4 endpoints
- 🆓 **Runs 100% locally** using Ollama — no API keys, no billing

---

## 🛠️ Tech Stack

| Layer | Technology |
|-------|-----------|
| Language | Java 17 |
| Framework | Spring Boot 3.3.5 |
| AI/LLM | LangChain4j 0.35.0 + Ollama (Llama 3.2) |
| Document Parsing | Apache Tika 2.9.2 |
| Utilities | Lombok |
| Build | Maven |

---

## 🚀 Getting Started

### Prerequisites
- JDK 17+
- Maven 3.9+
- [Ollama](https://ollama.com/download) installed

### 1. Install Ollama + pull model
```bash
curl -fsSL https://ollama.com/install.sh | sh
ollama pull llama3.2:3b